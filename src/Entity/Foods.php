<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Foods
 *
 * @ORM\Table(name="foods", indexes={@ORM\Index(name="index_foods_on_menus_id", columns={"menus_id"}), @ORM\Index(name="index_foods_on_restaurants_id", columns={"restaurants_id"}), @ORM\Index(name="index_foods_on_cuisines_id", columns={"cuisines_id"})})
 * @ORM\Entity
 */
class Foods
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
     * @ORM\Column(name="name", type="string", length=255, nullable=true, options={"default"="NULL"})
     */
    private $name = 'NULL';

    /**
     * @var bool|null
     *
     * @ORM\Column(name="active", type="boolean", nullable=true, options={"default"="NULL"})
     */
    private $active = 'NULL';

    /**
     * @var string|null
     *
     * @ORM\Column(name="price", type="decimal", precision=10, scale=2, nullable=true, options={"default"="NULL"})
     */
    private $price = 'NULL';

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

    /**
     * @var \Menus
     *
     * @ORM\ManyToOne(targetEntity="Menus")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="menus_id", referencedColumnName="id")
     * })
     */
    private $menus;


}
