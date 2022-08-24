package com.example.producto_aplicacionesmoviles.di

import com.example.producto_aplicacionesmoviles.domain.repository.SpecialtiesRepository
import com.example.producto_aplicacionesmoviles.domain.use_case.AddSpecialty
import com.example.producto_aplicacionesmoviles.domain.use_case.DeleteSpecialty
import com.example.producto_aplicacionesmoviles.domain.use_case.GetSpecialty
import com.example.producto_aplicacionesmoviles.domain.use_case.SpecialtyUseCases
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.producto_aplicacionesmoviles.core.Constants.SPECIALTY
import com.example.producto_aplicacionesmoviles.data.repository.SpecialtiesRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideFirebaseFirestore() = Firebase.firestore

    @Provides
    fun provideSpecialtiesRef(
        db: FirebaseFirestore
    ) = db.collection(SPECIALTY)

    @Provides
    fun provideSpecialtiesRepository(
        specialtiesRef: CollectionReference
    ): SpecialtiesRepository = SpecialtiesRepositoryImpl(specialtiesRef)

    @Provides
    fun provideUseCases(
        repo: SpecialtiesRepository
    ) = SpecialtyUseCases(
        getSpecialty = GetSpecialty(repo),
        addSpecialty = AddSpecialty(repo),
        deleteSpecialty = DeleteSpecialty(repo)
    )
}