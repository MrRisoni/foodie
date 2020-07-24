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

    public function getId(): ?string
    {
        return $this->id;
    }

    public function getName(): ?string
    {
        return $this->name;
    }

    public function setName(?string $name): self
    {
        $this->name = $name;

        return $this;
    }

    public function getActive(): ?bool
    {
        return $this->active;
    }

    public function setActive(?bool $active): self
    {
        $this->active = $active;

        return $this;
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

    public function getRestaurants(): ?Restaurants
    {
        return $this->restaurants;
    }

    public function setRestaurants(?Restaurants $restaurants): self
    {
        $this->restaurants = $restaurants;

        return $this;
    }

    public function getCuisines(): ?Cuisines
    {
        return $this->cuisines;
    }

    public function setCuisines(?Cuisines $cuisines): self
    {
        $this->cuisines = $cuisines;

        return $this;
    }

    public function getMenus(): ?Menus
    {
        return $this->menus;
    }

    public function setMenus(?Menus $menus): self
    {
        $this->menus = $menus;

        return $this;
    }


}
