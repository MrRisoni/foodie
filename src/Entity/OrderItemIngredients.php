<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * OrderItemIngredients
 *
 * @ORM\Table(name="order_item_ingredients", indexes={@ORM\Index(name="index_order_item_ingredients_on_order_items_id", columns={"order_items_id"}), @ORM\Index(name="index_order_item_ingredients_on_ingredients_id", columns={"ingredients_id"})})
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
     * @ORM\Column(name="price", type="decimal", precision=10, scale=2, nullable=true, options={"default"="NULL"})
     */
    private $price = 'NULL';

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

    public function getId(): ?string
    {
        return $this->id;
    }

    public function getPrice(): ?string
    {
        return $this->price;
    }

    public function setPrice(?string $price): self
    {
        $this->price = $price;

        return $this;
    }

    public function getOrderItems(): ?OrderItems
    {
        return $this->orderItems;
    }

    public function setOrderItems(?OrderItems $orderItems): self
    {
        $this->orderItems = $orderItems;

        return $this;
    }

    public function getIngredients(): ?Ingredients
    {
        return $this->ingredients;
    }

    public function setIngredients(?Ingredients $ingredients): self
    {
        $this->ingredients = $ingredients;

        return $this;
    }


}
