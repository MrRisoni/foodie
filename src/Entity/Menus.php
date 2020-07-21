<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Menus
 *
 * @ORM\Table(name="menus", indexes={@ORM\Index(name="index_menus_on_restaurants_id", columns={"restaurants_id"})})
 * @ORM\Entity
 */
class Menus
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
     * @var \Restaurants
     *
     * @ORM\ManyToOne(targetEntity="Restaurants")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="restaurants_id", referencedColumnName="id")
     * })
     */
    private $restaurants;


}
