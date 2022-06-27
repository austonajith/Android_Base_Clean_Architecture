package karaokeit.song.split.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import karaokeit.song.split.R
import karaokeit.song.split.databinding.ActivityMainBinding
import karaokeit.song.split.presentation.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel: MainActivityViewModel by viewModels()
    val binding: ActivityMainBinding by lazy { DataBindingUtil.setContentView(
        this, R.layout.activity_main) }
    
    @Inject lateinit var someValue: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        attachObservers()
        binding.btnGetFacts.setOnClickListener {
            fetchCatFacts()
        }

    }

    private fun attachObservers() {
        viewModel.facts.observe(this) {
            when(it){
                is State.Success ->{
                    binding.tvFacts.text = it.data.fact
                    Timber.d("Succcess == ${it.data}")
                }
                is State.Error ->{
                    Toast.makeText(this, it.exception.message, Toast.LENGTH_SHORT).show()
                    Timber.d("ERROR == ${it.exception}")
                }
                is State.Loading->{
                    Timber.d("LOADING")
                }
            }
        }
    }

    private fun fetchCatFacts() {
       viewModel.getFacts()
    }

}