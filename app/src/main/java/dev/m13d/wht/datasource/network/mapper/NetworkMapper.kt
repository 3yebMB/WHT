package dev.m13d.wht.datasource.network.mapper

import dev.m13d.wht.business.domain.model.Holyday
import dev.m13d.wht.business.domain.util.EntityMapper
import dev.m13d.wht.datasource.network.model.HolydayNetworkEntity
import javax.inject.Inject

class NetworkMapper

@Inject
constructor(): EntityMapper<HolydayNetworkEntity, Holyday> {

    override fun mapFromEntity(entity: HolydayNetworkEntity): Holyday {
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

    override fun mapToEntity(domainModel: Holyday): HolydayNetworkEntity {
        return HolydayNetworkEntity(
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

    fun mapFromEntityList(entities: List<HolydayNetworkEntity>): List<Holyday> {
        return entities.map { mapFromEntity(it) }
    }

}