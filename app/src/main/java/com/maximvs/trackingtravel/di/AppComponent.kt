package com.maximvs.trackingtravel.di

import com.maximvs.trackingtravel.viewmodel.RouteFragmentViewModel
import dagger.Module

@Module


    interface AppComponent {
        fun inject(RouteFragmentViewModel: RouteFragmentViewModel)
    }
