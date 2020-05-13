package pdsu.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdsu.project.dao.AreaDataMapper;
import pdsu.project.domain.AreaData;
import pdsu.project.service.AreaService;

/**
 * @author ljk
 */

@Service
@Transactional
/**
 * 地区接口
 */
public class AreaServiceImpl  implements AreaService {

    //注入地区接口
  @Autowired
  private AreaDataMapper areaDataMapper;

     @Override
      public String Address(Integer id) {
        //初始化一个地区变量
         String address;
         //根据报备id查询地区id信息
         Integer areaId = areaDataMapper.selectAreaId(id);
         //查询地点信息
         AreaData areaData = areaDataMapper.selectByPrimaryKey(areaId);
         if (areaData.getParentId()!=0){
             AreaData  areaData1 = areaDataMapper.selectByPrimaryKey(areaData.getParentId());
             if (areaData1.getParentId()!=0){
                 AreaData areaData2 = areaDataMapper.selectByPrimaryKey(areaData1.getCodeId());
                 address=areaData2.getCityName()+areaData1.getCityName()+areaData.getCityName();
             }else {
                 address=areaData1.getCityName()+areaData.getCityName();
             }
         }else {
             address=areaData.getCityName();
         }
         return address;
     }

    @Override
    public String HomeAddress(Integer id) {
        String address;
        AreaData areaData = areaDataMapper.selectByPrimaryKey(id);
        if (areaData.getParentId()!=0){
            AreaData  areaData1 = areaDataMapper.selectByPrimaryKey(areaData.getParentId());
            if (areaData1.getParentId()!=0){
                AreaData areaData2 = areaDataMapper.selectByPrimaryKey(areaData1.getCodeId());
                address=areaData2.getCityName()+areaData1.getCityName()+areaData.getCityName();
            }else {
                address=areaData1.getCityName()+areaData.getCityName();
            }
        }else {
            address=areaData.getCityName();
        }
        return address;

    }
}
