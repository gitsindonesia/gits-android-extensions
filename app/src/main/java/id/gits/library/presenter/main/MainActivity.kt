package id.gits.library.presenter.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.gits.library.MainApplication
import id.gits.library.data.Resource
import id.gits.library.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private lateinit var binding: ActivityMainBinding

    private val documentationAdapter = DocumentationAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MainApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
        initObserver()
    }

    private fun initData() {
        viewModel.loadDocumentations()
    }

    private fun initObserver() {
        viewModel.documentations.observe(this) {
            when (it) {
                is Resource.Loading -> {
                    // Nothing to do
                }
                is Resource.Success -> {
                    documentationAdapter.setDocumentations(it.data)
                }
                is Resource.Error -> {
                    // Nothing to do
                }
            }
        }
    }

    private fun initView() {
        binding.rvDocumentation.adapter = documentationAdapter
    }
}