package com.arvin.mapper;


import com.arvin.po.Items;
import com.arvin.po.ItemsCustom;
import com.arvin.po.ItemsVO;

import java.util.List;

public interface ItemsMapperCustom
{
     List<ItemsCustom> queryItemsByName(ItemsVO itemsVO) throws Exception;

     void deleteItemsByIds(Integer[] ids) throws Exception;
}