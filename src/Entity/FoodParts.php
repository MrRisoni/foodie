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
     * @ORM\Column(name="name", type="string", length=255, nullable=true, options={"default"="NULL"})
     */
    private $name = 'NULL';

    /**
     * @var bool|null
     *
     * @ORM\Column(name="allow_many", type="boolean", nullable=true, options={"default"="NULL"})
     */
    private $allowMany = 'NULL';

    /**
     * @var \Foods
     *
     * @ORM\ManyToOne(targetEntity="Foods")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="foods_id", referencedColumnName="id")
     * })
     */
    private $foods;

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

    public function getAllowMany(): ?bool
    {
        return $this->allowMany;
    }

    public function setAllowMany(?bool $allowMany): self
    {
        $this->allowMany = $allowMany;

        return $this;
    }

    public function getFoods(): ?Foods
    {
        return $this->foods;
    }

    public function setFoods(?Foods $foods): self
    {
        $this->foods = $foods;

        return $this;
    }


}
