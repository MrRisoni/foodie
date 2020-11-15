package dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private BigDecimal final_price;
    private Date created_at;
    private List<OrderItemDto> items;
    private PaymentMethodDto payObj;
    private UserAddressDto addrObj;
}
