package dev.m13d.wht.framework.datasource.cache.mapper

import dev.m13d.wht.business.domain.model.Holyday
import dev.m13d.wht.framework.datasource.cache.model.HolydayCacheEntity
import dev.m13d.wht.business.domain.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor(): EntityMapper<HolydayCacheEntity, Holyday> {
    override fun mapFromEntity(entity: HolydayCacheEntity): Holyday {
        return Holyday(
            date = entity.date,
            localName = entity.localName,
            name = entity.name,
            countryCode = entity.countryCode,
            fixed = entity.fixed,
            global = entity.global,
            counties = entity.counties,
            launchYear = entity.launchYear,
            type = entity.type
        )
    }

    override fun mapToEntity(domainModel: Holyday): HolydayCacheEntity {
        return HolydayCacheEntity(
            date = domainModel.date,
            localName = domainModel.localName,
            name = domainModel.name,
            countryCode = domainModel.countryCode,
            fixed = domainModel.fixed,
            global = domainModel.global,
            counties = domainModel.counties,
            launchYear = domainModel.launchYear,
            type = domainModel.type
        )
    }

    fun mapFromEntityList(entities: List<HolydayCacheEntity>): List<Holyday> {
        return entities.map { mapFromEntity(it) }
    }
}