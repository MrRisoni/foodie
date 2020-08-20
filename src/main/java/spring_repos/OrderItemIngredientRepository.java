package spring_repos;

import models.OrderItemIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemIngredientRepository extends CrudRepository<OrderItemIngredient,Long> {
}
