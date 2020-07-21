<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * FoodPartIngredients
 *
 * @ORM\Table(name="food_part_ingredients", uniqueConstraints={@ORM\UniqueConstraint(name="food_part_id_2", columns={"food_part_id", "ingredient_id"})}, indexes={@ORM\Index(name="food_part_id", columns={"food_part_id"}), @ORM\Index(name="ingredient_id", columns={"ingredient_id"})})
 * @ORM\Entity
 */
class FoodPartIngredients
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="bigint", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var \FoodParts
     *
     * @ORM\ManyToOne(targetEntity="FoodParts")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="food_part_id", referencedColumnName="id")
     * })
     */
    private $foodPart;

    /**
     * @var \Ingredients
     *
     * @ORM\ManyToOne(targetEntity="Ingredients")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ingredient_id", referencedColumnName="id")
     * })
     */
    private $ingredient;


}
