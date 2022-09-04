package com.example.producto_aplicacionesmoviles.core

import com.example.producto_aplicacionesmoviles.core.Constants.SPECIALTY_COLLECTION_NAME
import com.example.producto_aplicacionesmoviles.core.Constants.SPECIALTY_DOCTOR_COLLECTION_NAME
import com.example.producto_aplicacionesmoviles.core.Constants.USER_COLLECTION_NAME
import com.example.producto_aplicacionesmoviles.core.Constants.WORKDAY_COLLECTION_NAME
import com.example.producto_aplicacionesmoviles.data.repository.SpecialtiesRepositoryImpl
import com.example.producto_aplicacionesmoviles.data.repository.SpecialtyDoctorsRepositoryImpl
import com.example.producto_aplicacionesmoviles.data.repository.UsersRepositoryImpl
import com.example.producto_aplicacionesmoviles.data.repository.WorkDaysRepositoryImpl
import com.example.producto_aplicacionesmoviles.domain.repository.SpecialtiesRepository
import com.example.producto_aplicacionesmoviles.domain.repository.SpecialtyDoctorsRepository
import com.example.producto_aplicacionesmoviles.domain.repository.UsersRepository
import com.example.producto_aplicacionesmoviles.domain.repository.WorkDaysRepository
import com.example.producto_aplicacionesmoviles.domain.use_case.SpecialtyDoctorUseCases
import com.example.producto_aplicacionesmoviles.domain.use_case.SpecialtyUseCases
import com.example.producto_aplicacionesmoviles.domain.use_case.UserUseCases
import com.example.producto_aplicacionesmoviles.domain.use_case.WorkDaysUseCases
import com.example.producto_aplicacionesmoviles.domain.use_case.specialty.AddSpecialty
import com.example.producto_aplicacionesmoviles.domain.use_case.specialty.DeleteSpecialty
import com.example.producto_aplicacionesmoviles.domain.use_case.specialty.GetSpecialty
import com.example.producto_aplicacionesmoviles.domain.use_case.specialtydoctors.AddSpecialtyDoctor
import com.example.producto_aplicacionesmoviles.domain.use_case.specialtydoctors.DeleteSpecialtyDoctor
import com.example.producto_aplicacionesmoviles.domain.use_case.specialtydoctors.GetSpecialtyDoctors
import com.example.producto_aplicacionesmoviles.domain.use_case.specialtydoctors.GetSpecialtyDoctorsBySpecialtyId
import com.example.producto_aplicacionesmoviles.domain.use_case.users.*
import com.example.producto_aplicacionesmoviles.domain.use_case.workday.AddWorkDay
import com.example.producto_aplicacionesmoviles.domain.use_case.workday.DeleteWorkDay
import com.example.producto_aplicacionesmoviles.domain.use_case.workday.GetWorkDays
import com.example.producto_aplicacionesmoviles.domain.use_case.workday.GetWorkDaysByUserId
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideFirebaseFirestore() : FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideUsersRepository(
        db: FirebaseFirestore
    ): UsersRepository = UsersRepositoryImpl(db.collection(USER_COLLECTION_NAME))

    @Provides
    fun provideSpecialtiesRepository(
        db: FirebaseFirestore
    ): SpecialtiesRepository = SpecialtiesRepositoryImpl(db.collection(SPECIALTY_COLLECTION_NAME))

    @Provides
    fun provideSpecialtyDoctorsRepository(
        db: FirebaseFirestore
    ): SpecialtyDoctorsRepository = SpecialtyDoctorsRepositoryImpl(db.collection(SPECIALTY_DOCTOR_COLLECTION_NAME))

    @Provides
    fun provideWorkDaysRepository(
        db: FirebaseFirestore
    ): WorkDaysRepository = WorkDaysRepositoryImpl(db.collection(WORKDAY_COLLECTION_NAME))

    @Provides
    fun provideUserUseCases(
        repo: UsersRepository
    ) : UserUseCases = UserUseCases(
        getUsers = GetUsers(repo),
        getUserById = GetUserByUserId(repo),
        getUserByAuthId = GetUserByAuthId(repo),
        addUser = AddUser(repo),
        deleteUser = DeleteUser(repo)
    )

    @Provides
    fun provideSpecialtyUseCases(
        repo: SpecialtiesRepository
    ) : SpecialtyUseCases = SpecialtyUseCases(
        getSpecialty = GetSpecialty(repo),
        addSpecialty = AddSpecialty(repo),
        deleteSpecialty = DeleteSpecialty(repo)
    )

    @Provides
    fun provideSpecialtyDoctorUseCases(
        repo: SpecialtyDoctorsRepository
    ) : SpecialtyDoctorUseCases = SpecialtyDoctorUseCases(
        getSpecialtyDoctors = GetSpecialtyDoctors(repo),
        getSpecialtyDoctorsBySpecialtyId = GetSpecialtyDoctorsBySpecialtyId(repo),
        addSpecialtyDoctor = AddSpecialtyDoctor(repo),
        deleteSpecialtyDoctor = DeleteSpecialtyDoctor(repo)
    )

    @Provides
    fun provideWorkDayUseCases(
        repo: WorkDaysRepository
    ) : WorkDaysUseCases = WorkDaysUseCases(
        getWorkDays = GetWorkDays(repo),
        getWorkDaysByUserId = GetWorkDaysByUserId(repo),
        addWorkDay = AddWorkDay(repo),
        deleteWorkDay = DeleteWorkDay(repo)
    )

}