package com.example.electricity.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.electricity.R
import com.example.electricity.base.BaseBottomSheet
import com.example.electricity.common.Constants
import com.example.electricity.network.data.RepositoryDetails
import kotlinx.android.synthetic.main.repository_bottom_sheet.*

class RepositoryDetailsBottomSheet : BaseBottomSheet() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.repository_bottom_sheet, container,
            false
        )
    }

    private fun initData() {
        val args = arguments
        val repositoryDetailsData =
            args?.getParcelable<RepositoryDetails>(Constants.Data.REPOSITORY_ITEM_KEY)
        projectNameTextViewTitle.text = repositoryDetailsData?.name ?: ""
        idTextViewDynamic.text = repositoryDetailsData?.id.toString()
        urlTextViewDynamic.text = repositoryDetailsData?.html_url ?: ""
        starTextViewDynamic.text = repositoryDetailsData?.stargazersCount.toString()
        issueTextViewDynamic.text = repositoryDetailsData?.openIssuesCount.toString()
    }

    companion object {
        fun newInstance(repo: RepositoryDetails): RepositoryDetailsBottomSheet {
            val args = Bundle()
            args.putParcelable(Constants.Data.REPOSITORY_ITEM_KEY, repo)
            val fragment = RepositoryDetailsBottomSheet()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }
}
