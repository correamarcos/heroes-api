package com.marcoscorrea.heroes.resources.hero

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HeroEntityRepository : JpaRepository<HeroEntity, Long>