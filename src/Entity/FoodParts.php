<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * FoodParts
 *
 * @ORM\Table(name="food_parts", indexes={@ORM\Index(name="index_food_parts_on_foods_id", columns={"foods_id"})})
 * @ORM\Entity
 */
class FoodParts
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
     * @ORM\Column(name="name", type="string", length=255, nullable=true)
     */
    private $name;

    /**
     * @var bool|null
     *
     * @ORM\Column(name="allow_many", type="boolean", nullable=true)
     */
    private $allowMany;

    /**
     * @var \Foods
     *
     * @ORM\ManyToOne(targetEntity="Foods")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="foods_id", referencedColumnName="id")
     * })
     */
    private $foods;


}
