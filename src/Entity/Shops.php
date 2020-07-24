<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Shops
 *
 * @ORM\Table(name="shops", indexes={@ORM\Index(name="index_shops_on_suburbs_id", columns={"suburbs_id"}), @ORM\Index(name="index_shops_on_restaurants_id", columns={"restaurants_id"})})
 * @ORM\Entity
 */
class Shops
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
     * @ORM\Column(name="active", type="boolean", nullable=true, options={"default"="NULL"})
     */
    private $active = 'NULL';

    /**
     * @var \Suburbs
     *
     * @ORM\ManyToOne(targetEntity="Suburbs")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="suburbs_id", referencedColumnName="id")
     * })
     */
    private $suburbs;

    /**
     * @var \Restaurants
     *
     * @ORM\ManyToOne(targetEntity="Restaurants")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="restaurants_id", referencedColumnName="id")
     * })
     */
    private $restaurants;


}
