package ru.netology.nerecipe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ru.netology.nerecipe.databinding.FragmentFilterBinding
import ru.netology.nerecipe.viewModel.RecipeViewModel

class RecipeFilterFragment : Fragment() {
    private val viewModel by activityViewModels<RecipeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentFilterBinding.inflate(layoutInflater, container, false).also { binding ->

        binding.buttonApply.setOnClickListener {
            onApplyButtonClicked(binding)
        }
        if (viewModel.toggleCheckEuropean)
            binding.checkBoxEuropean.isChecked = true
        if (viewModel.toggleCheckAsian)
            binding.checkBoxAsian.isChecked = true
        if (viewModel.toggleCheckPanasian)
            binding.checkBoxPanasian.isChecked = true
        if (viewModel.toggleCheckEastern)
            binding.checkBoxEastern.isChecked = true
        if (viewModel.toggleCheckAmerican)
            binding.checkBoxAmerican.isChecked = true
        if (viewModel.toggleCheckRussian)
            binding.checkBoxRussian.isChecked = true
        if (viewModel.toggleCheckMediterranean)
            binding.checkBoxMediterranean.isChecked = true
    }.root

    private fun onApplyButtonClicked(binding: FragmentFilterBinding) {
        var checkedCount = 0
        val numberOfFilters = 7

        if (!binding.checkBoxEuropean.isChecked) {
            checkedCount++
            viewModel.showEuropean("Европейская кухня")
        } else viewModel.toggleCheckEuropean = true
        if (!binding.checkBoxAsian.isChecked) {
            checkedCount++
            viewModel.showAsian("Азиатская кухня")
        } else viewModel.toggleCheckAsian = true
        if (!binding.checkBoxPanasian.isChecked) {
            checkedCount++
            viewModel.showPanasian("Паназиатская кухня")
        } else viewModel.toggleCheckPanasian = true
        if (!binding.checkBoxEastern.isChecked) {
            checkedCount++
            viewModel.showEastern("Восточная кухня")
        } else viewModel.toggleCheckEastern = true
        if (!binding.checkBoxAmerican.isChecked) {
            checkedCount++
            viewModel.showAmerican("Американская кухня")
        } else viewModel.toggleCheckAmerican = true
        if (!binding.checkBoxRussian.isChecked) {
            checkedCount++
            viewModel.showRussian("Русская кухня")
        } else viewModel.toggleCheckRussian = true
        if (!binding.checkBoxMediterranean.isChecked) {
            checkedCount++
            viewModel.showMediterranean( "Средиземноморская кухня")
        } else viewModel.toggleCheckMediterranean = true

        if (checkedCount == numberOfFilters) {
            Toast.makeText(activity, "Вы не выбрали ни одного фильтра", Toast.LENGTH_LONG).show()
            viewModel.clearFilter()
            viewModel.filterIsActive = false
            findNavController().popBackStack()
        } else findNavController().popBackStack()
    }

}
