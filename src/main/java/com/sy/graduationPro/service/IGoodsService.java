package com.sy.graduationPro.service;

import com.sy.graduationPro.vo.GoodsKindVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sunguiyong on 2018/5/24.
 */
@Service(value = "goodsService")
public interface IGoodsService {

    List<GoodsKindVO> getGoodsAndKind();
}
