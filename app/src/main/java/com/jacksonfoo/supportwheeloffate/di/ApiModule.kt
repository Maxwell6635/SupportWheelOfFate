package com.jacksonfoo.supportwheeloffate.di

import com.jacksonfoo.supportwheeloffate.data.api.API
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(API::class.java) }
}