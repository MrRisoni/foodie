<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * OrderItemIngredients
 *
 * @ORM\Table(name="order_item_ingredients", indexes={@ORM\Index(name="index_order_item_ingredients_on_ingredients_id", columns={"ingredients_id"}), @ORM\Index(name="index_order_item_ingredients_on_order_items_id", columns={"order_items_id"})})
 * @ORM\Entity
 */
class OrderItemIngredients
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="bigint", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string|null
     *
     * @ORM\Column(name="price", type="decimal", precision=10, scale=2, nullable=true)
     */
    private $price;

    /**
     * @var \OrderItems
     *
     * @ORM\ManyToOne(targetEntity="OrderItems")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="order_items_id", referencedColumnName="id")
     * })
     */
    private $orderItems;

    /**
     * @var \Ingredients
     *
     * @ORM\ManyToOne(targetEntity="Ingredients")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ingredients_id", referencedColumnName="id")
     * })
     */
    private $ingredients;


}
