<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Cities
 *
 * @ORM\Table(name="cities", indexes={@ORM\Index(name="index_cities_on_perfectures_id", columns={"perfectures_id"})})
 * @ORM\Entity
 */
class Cities
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
     * @var \Perfectures
     *
     * @ORM\ManyToOne(targetEntity="Perfectures")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="perfectures_id", referencedColumnName="id")
     * })
     */
    private $perfectures;

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

    public function getPerfectures(): ?Perfectures
    {
        return $this->perfectures;
    }

    public function setPerfectures(?Perfectures $perfectures): self
    {
        $this->perfectures = $perfectures;

        return $this;
    }


}
