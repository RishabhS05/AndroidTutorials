package com.example.hilttutorials.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
//@Module tells Hilt that this is a module.
@Module
//@InstallIn tells Hilt the containers where the bindings are available by specifying a Hilt component
@InstallIn(SingletonComponent::class)
class NetworkModule {
@Provides
 fun provideNetworkApiInterface(){

 }
}