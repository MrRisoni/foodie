<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * RestaurantsCuisines
 *
 * @ORM\Table(name="restaurants_cuisines", indexes={@ORM\Index(name="index_restaurants_cuisines_on_cuisines_id", columns={"cuisines_id"}), @ORM\Index(name="index_restaurants_cuisines_on_restaurants_id", columns={"restaurants_id"})})
 * @ORM\Entity
 */
class RestaurantsCuisines
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
     * @var bool|null
     *
     * @ORM\Column(name="active", type="boolean", nullable=true)
     */
    private $active;

    /**
     * @var \Restaurants
     *
     * @ORM\ManyToOne(targetEntity="Restaurants")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="restaurants_id", referencedColumnName="id")
     * })
     */
    private $restaurants;

    /**
     * @var \Cuisines
     *
     * @ORM\ManyToOne(targetEntity="Cuisines")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="cuisines_id", referencedColumnName="id")
     * })
     */
    private $cuisines;


}
