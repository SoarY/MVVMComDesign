package com.soar.network.constant;


import com.soar.network.bean.BaseResultBean;
import com.soar.network.bean.response.GankIoDayBean;
import com.soar.network.bean.response.NaviBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * YONG_
 */
public interface API {

    //---------------------------------GankIo-API---------------------------------//

    /**
     * 每日推荐
     * eg:http://gank.io/api/day/2015/08/06
     */
    @GET("day/{year}/{month}/{day}")
    Observable<GankIoDayBean> getGankIoDay(@Path("year") String year, @Path("month") String month, @Path("day") String day);

    /**
     * 导航数据
     */
    @GET("navi/json")
    Observable<BaseResultBean<List<NaviBean>>> getNaviJson();
}
