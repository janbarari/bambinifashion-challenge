package com.bambinifashion.home.view

import android.graphics.Color
import android.os.Build
import android.text.Html
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenResumed
import androidx.recyclerview.widget.LinearLayoutManager
import com.bambinifashion.architecture.fragment.ViewModelFragment
import com.bambinifashion.designsystem.Item
import com.bambinifashion.designsystem.banner.Banner
import com.bambinifashion.designsystem.featuredcategory.FeaturedCategories
import com.bambinifashion.designsystem.featuredcategory.FeaturedCategory
import com.bambinifashion.designsystem.quadro.Quadro
import com.bambinifashion.home.R
import com.bambinifashion.home.databinding.HomeFragmentBinding
import com.bambinifashion.home.domain.PromotionPage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : ViewModelFragment<HomeFragmentBinding, HomeViewModel>(
    R.layout.home_fragment,
    HomeViewModel::class.java
) {

    private val homeAdapter: HomeAdapter = HomeAdapter()

    override fun getBindingLayout(v: View): HomeFragmentBinding {
        return HomeFragmentBinding.bind(v)
    }

    override fun setupViews() {
        getBinding().list.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = homeAdapter
        }
    }

    override fun setupObservers() {
        viewLifecycleOwner
            .lifecycleScope
            .launchWhenStarted {
                launch {
                    viewModel.state.collect {

                        getBinding().spinner.visibility =
                            if (it.isLoading) View.VISIBLE else View.GONE

                        if (it.error != null) {
                            getBinding().error.text = it.error.message
                            getBinding().error.visibility = View.VISIBLE
                        } else {
                            getBinding().error.visibility = View.GONE
                        }

                        if (it.page != null && it.promotions != null) {
                            val landingListData = mutableListOf<Item>()
                            it.page.page.content.forEachIndexed { i, m ->
                                if (m.name == "banner") {
                                    landingListData.add(
                                        Banner(
                                            i,
                                            m.data.image!!.src
                                        )
                                    )
                                }

                                if (m.name == "featured-categories") {
                                    val categories = mutableListOf<FeaturedCategory>()
                                    m.data.categories!!.forEach {
                                        categories.add(
                                            FeaturedCategory(
                                                title = it.title,
                                                imageUrl = it.image.src
                                            )
                                        )
                                    }
                                    landingListData.add(
                                        FeaturedCategories(
                                            i,
                                            categories
                                        )
                                    )
                                }

                                if(m.name == "quadro") {
                                    val categories = mutableListOf<FeaturedCategory>()
                                    m.data.categories!!.forEach {
                                        categories.add(
                                            FeaturedCategory(
                                                title = it.title,
                                                imageUrl = it.image.src,
                                                backgroundColor = Color.parseColor(it.backgroundColor)
                                            )
                                        )
                                    }
                                    landingListData.add(
                                        Quadro(
                                            id = i,
                                            title = m.data.title!!,
                                            imageUrl = m.data.image!!.src,
                                            categories = categories
                                        )
                                    )
                                }

                            }
                            homeAdapter.updateList(landingListData)

                            loopPromotions(it.promotions)
                        }

                    }
                }
            }
    }

    private fun loopPromotions(promotion: PromotionPage) {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            promotion.user.proline.center.items.forEach {
                getBinding().promotion.text = Html.fromHtml(it.content, Html.FROM_HTML_MODE_COMPACT)
                delay(it.duration.toLong())
            }
            loopPromotions(promotion)
        }
    }
}
