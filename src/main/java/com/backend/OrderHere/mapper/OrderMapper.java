package com.backend.OrderHere.mapper;

import com.backend.OrderHere.dto.PlaceOrderDTO;
import com.backend.OrderHere.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    Order dtoToOrder(PlaceOrderDTO dto);
}
