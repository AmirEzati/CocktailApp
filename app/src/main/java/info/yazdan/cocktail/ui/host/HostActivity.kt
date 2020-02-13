package info.yazdan.cocktail.ui.host

import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import info.yazdan.cocktail.R
import info.yazdan.cocktail.databinding.ActivityHostBinding
import info.yazdan.cocktail.ui.base.BaseActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class HostActivity : BaseActivity(), KodeinAware {

    override val kodein: Kodein by kodein()
    private val factory: HostViewModelFactory by instance()

    private lateinit var binding: ActivityHostBinding
    private lateinit var viewModel: HostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setWindowFlag(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
            false
        )

        binding = DataBindingUtil.setContentView(this, R.layout.activity_host)
        viewModel = ViewModelProviders.of(this, factory).get(HostViewModel::class.java)
        binding.lifecycleOwner = this
    }
}