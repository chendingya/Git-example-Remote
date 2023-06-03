package org.fffd.l23o6.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.fffd.l23o6.pojo.entity.RouteEntity;
import org.fffd.l23o6.pojo.vo.route.RouteVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T18:24:41+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class RouteMapperImpl implements RouteMapper {

    @Override
    public RouteVO toRouteVO(RouteEntity routeEntity) {
        if ( routeEntity == null ) {
            return null;
        }

        RouteVO routeVO = new RouteVO();

        routeVO.setId( routeEntity.getId() );
        routeVO.setName( routeEntity.getName() );
        routeVO.setStationIds( longListToIntegerList( routeEntity.getStationIds() ) );

        return routeVO;
    }

    protected List<Integer> longListToIntegerList(List<Long> list) {
        if ( list == null ) {
            return null;
        }

        List<Integer> list1 = new ArrayList<Integer>( list.size() );
        for ( Long long1 : list ) {
            list1.add( long1.intValue() );
        }

        return list1;
    }
}
