package com.example.myapplication.common.usecase

import com.github.terrakok.cicerone.Router

class BackNavigatorUseCaseImpl(
    private val router: Router
) : BackNavigatorUseCase {

    override fun invoke() = router.exit()
}