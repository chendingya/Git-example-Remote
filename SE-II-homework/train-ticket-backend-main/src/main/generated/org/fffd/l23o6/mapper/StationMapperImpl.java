package org.fffd.l23o6.mapper;

import javax.annotation.processing.Generated;
import org.fffd.l23o6.pojo.entity.StationEntity;
import org.fffd.l23o6.pojo.vo.station.StationVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T18:24:41+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class StationMapperImpl implements StationMapper {

    @Override
    public StationVO toStationVO(StationEntity stationEntity) {
        if ( stationEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = stationEntity.getId();
        name = stationEntity.getName();

        StationVO stationVO = new StationVO( id, name );

        return stationVO;
    }
}
