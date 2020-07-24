-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 24, 2020 at 10:24 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `foodie`
--

-- --------------------------------------------------------

--
-- Table structure for table `cities`
--

CREATE TABLE `cities` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `perfectures_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cities`
--

INSERT INTO `cities` (`id`, `name`, `perfectures_id`) VALUES
(1, 'Αθήνα', 1);

-- --------------------------------------------------------

--
-- Table structure for table `credit_cards`
--

CREATE TABLE `credit_cards` (
  `id` bigint(20) NOT NULL,
  `bin` varchar(255) DEFAULT NULL,
  `lastfour` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `cuisines`
--

CREATE TABLE `cuisines` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cuisines`
--

INSERT INTO `cuisines` (`id`, `name`) VALUES
(2, 'Burger'),
(4, 'Pizza'),
(5, 'Ζυμαρικά'),
(3, 'Κινέζικο'),
(1, 'Σουβλάκι');

-- --------------------------------------------------------

--
-- Table structure for table `donations`
--

CREATE TABLE `donations` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `foods`
--

CREATE TABLE `foods` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `restaurants_id` bigint(20) DEFAULT NULL,
  `cuisines_id` bigint(20) DEFAULT NULL,
  `menus_id` bigint(20) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `foods`
--

INSERT INTO `foods` (`id`, `name`, `active`, `restaurants_id`, `cuisines_id`, `menus_id`, `price`) VALUES
(1, 'Λουκανικο Καρδιτσας Πιτα Γυρο', 1, 1, 1, 3, '2.80');

-- --------------------------------------------------------

--
-- Table structure for table `food_parts`
--

CREATE TABLE `food_parts` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `foods_id` bigint(20) DEFAULT NULL,
  `allow_many` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `food_parts`
--

INSERT INTO `food_parts` (`id`, `name`, `foods_id`, `allow_many`) VALUES
(1, 'Πίτα', 1, 0),
(2, 'Συστατικά', 1, 1),
(3, 'Αλοιφές', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `food_part_ingredients`
--

CREATE TABLE `food_part_ingredients` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `food_part_id` bigint(20) NOT NULL,
  `ingredient_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `food_part_ingredients`
--

INSERT INTO `food_part_ingredients` (`id`, `food_part_id`, `ingredient_id`) VALUES
(1, 1, 4),
(2, 1, 5),
(3, 1, 6);

-- --------------------------------------------------------

--
-- Table structure for table `ingredients`
--

CREATE TABLE `ingredients` (
  `id` bigint(20) NOT NULL,
  `restaurant_id` bigint(20) NOT NULL,
  `name` varchar(55) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ingredients`
--

INSERT INTO `ingredients` (`id`, `restaurant_id`, `name`, `price`) VALUES
(1, 1, 'Τηγανητές', '0.00'),
(2, 1, 'Κρεμμύδι', '0.00'),
(3, 1, 'Onion Rings', '1.20'),
(4, 1, 'Πολύσπορη', '1.00'),
(5, 1, 'Αραβική', '1.00'),
(6, 1, 'Κανονική', '1.00');

-- --------------------------------------------------------

--
-- Table structure for table `menus`
--

CREATE TABLE `menus` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restaurants_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menus`
--

INSERT INTO `menus` (`id`, `name`, `restaurants_id`) VALUES
(1, 'Ορεκτικά', 1),
(2, 'Σαλάτες', 1),
(3, 'Τυλιχτά', 1);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `success` tinyint(1) DEFAULT NULL,
  `final` decimal(10,2) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `users_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `success`, `final`, `created_at`, `updated_at`, `users_id`) VALUES
(1, 1, '23.45', '2020-05-23 10:58:37', '2020-05-23 10:58:37', 1);

-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `id` bigint(20) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `food_id` bigint(20) DEFAULT NULL,
  `comment` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `order_item_ingredients`
--

CREATE TABLE `order_item_ingredients` (
  `id` bigint(20) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `order_items_id` bigint(20) DEFAULT NULL,
  `ingredients_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `perfectures`
--

CREATE TABLE `perfectures` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `perfectures`
--

INSERT INTO `perfectures` (`id`, `name`) VALUES
(1, 'Αττική');

-- --------------------------------------------------------

--
-- Table structure for table `restaurants`
--

CREATE TABLE `restaurants` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurants`
--

INSERT INTO `restaurants` (`id`, `name`) VALUES
(1, 'stage grill'),
(2, 'Kalamaki and Burger Story'),
(3, 'La pasteria'),
(4, 'Mr Dim');

-- --------------------------------------------------------

--
-- Table structure for table `restaurants_cuisines`
--

CREATE TABLE `restaurants_cuisines` (
  `id` bigint(20) NOT NULL,
  `active` tinyint(1) DEFAULT 1,
  `restaurants_id` bigint(20) DEFAULT NULL,
  `cuisines_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurants_cuisines`
--

INSERT INTO `restaurants_cuisines` (`id`, `active`, `restaurants_id`, `cuisines_id`) VALUES
(1, 1, 1, 1),
(2, 1, 3, 4),
(3, 1, 3, 5),
(4, 1, 4, 3),
(5, 1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `shops`
--

CREATE TABLE `shops` (
  `id` bigint(20) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `suburbs_id` bigint(20) DEFAULT NULL,
  `restaurants_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shops`
--

INSERT INTO `shops` (`id`, `active`, `suburbs_id`, `restaurants_id`) VALUES
(1, 1, 2, 1),
(2, 1, 8, 3),
(3, 1, 8, 4);

-- --------------------------------------------------------

--
-- Table structure for table `shops_serving_suburbs`
--

CREATE TABLE `shops_serving_suburbs` (
  `sssb_id` bigint(20) UNSIGNED NOT NULL,
  `sssb_shop_id` bigint(20) NOT NULL,
  `sssb_suburb_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shops_serving_suburbs`
--

INSERT INTO `shops_serving_suburbs` (`sssb_id`, `sssb_shop_id`, `sssb_suburb_id`) VALUES
(5, 1, 2),
(1, 2, 2),
(3, 2, 3),
(2, 2, 6),
(4, 3, 8);

-- --------------------------------------------------------

--
-- Table structure for table `suburbs`
--

CREATE TABLE `suburbs` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `cities_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `suburbs`
--

INSERT INTO `suburbs` (`id`, `name`, `cities_id`) VALUES
(2, 'Καλλιθεα', 1),
(1, 'Κιφησια', 1),
(4, 'Μαρούσι', 1),
(5, 'Μοσχάτο', 1),
(8, 'Νέα Σμύρνη', 1),
(6, 'Νέος Κόσμος', 1),
(3, 'Παλαιο Φάληρο', 1),
(7, 'Τζιτζιφιές', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `name`, `passwd`, `created_at`, `updated_at`) VALUES
(1, 'vag', 'vag', 'vag', '2020-05-23 10:58:18', '2020-05-23 10:58:18'),
(2, 'vagos', 'vagos', 'vagos', '2020-05-23 10:58:18', '2020-05-23 10:58:18');

-- --------------------------------------------------------

--
-- Table structure for table `users_addresses`
--

CREATE TABLE `users_addresses` (
  `add_id` bigint(20) UNSIGNED NOT NULL,
  `add_user_id` bigint(20) NOT NULL,
  `add_suburb_id` bigint(20) NOT NULL,
  `add_street` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users_addresses`
--

INSERT INTO `users_addresses` (`add_id`, `add_user_id`, `add_suburb_id`, `add_street`) VALUES
(1, 1, 2, '45');

-- --------------------------------------------------------

--
-- Table structure for table `users_favorite_restaurants`
--

CREATE TABLE `users_favorite_restaurants` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `restaurant_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users_favorite_restaurants`
--

INSERT INTO `users_favorite_restaurants` (`id`, `user_id`, `restaurant_id`) VALUES
(1, 1, 2),
(2, 1, 4),
(3, 2, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cities`
--
ALTER TABLE `cities`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_cities_on_perfectures_id` (`perfectures_id`);

--
-- Indexes for table `credit_cards`
--
ALTER TABLE `credit_cards`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `cuisines`
--
ALTER TABLE `cuisines`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `donations`
--
ALTER TABLE `donations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_foods_on_restaurants_id` (`restaurants_id`),
  ADD KEY `index_foods_on_cuisines_id` (`cuisines_id`),
  ADD KEY `index_foods_on_menus_id` (`menus_id`);

--
-- Indexes for table `food_parts`
--
ALTER TABLE `food_parts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_food_parts_on_foods_id` (`foods_id`);

--
-- Indexes for table `food_part_ingredients`
--
ALTER TABLE `food_part_ingredients`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `food_part_id_2` (`food_part_id`,`ingredient_id`),
  ADD KEY `food_part_id` (`food_part_id`),
  ADD KEY `ingredient_id` (`ingredient_id`);

--
-- Indexes for table `ingredients`
--
ALTER TABLE `ingredients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `restaurant_id` (`restaurant_id`);

--
-- Indexes for table `menus`
--
ALTER TABLE `menus`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_menus_on_restaurants_id` (`restaurants_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_orders_on_users_id` (`users_id`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_order_items_on_food_id` (`food_id`);

--
-- Indexes for table `order_item_ingredients`
--
ALTER TABLE `order_item_ingredients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_order_item_ingredients_on_order_items_id` (`order_items_id`),
  ADD KEY `index_order_item_ingredients_on_ingredients_id` (`ingredients_id`);

--
-- Indexes for table `perfectures`
--
ALTER TABLE `perfectures`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restaurants_cuisines`
--
ALTER TABLE `restaurants_cuisines`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `restaurants_id` (`restaurants_id`,`cuisines_id`),
  ADD KEY `index_restaurants_cuisines_on_restaurants_id` (`restaurants_id`),
  ADD KEY `index_restaurants_cuisines_on_cuisines_id` (`cuisines_id`);

--
-- Indexes for table `shops`
--
ALTER TABLE `shops`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_shops_on_suburbs_id` (`suburbs_id`),
  ADD KEY `index_shops_on_restaurants_id` (`restaurants_id`);

--
-- Indexes for table `shops_serving_suburbs`
--
ALTER TABLE `shops_serving_suburbs`
  ADD PRIMARY KEY (`sssb_id`),
  ADD UNIQUE KEY `sssb_shop_id_2` (`sssb_shop_id`,`sssb_suburb_id`),
  ADD KEY `sssb_shop_id` (`sssb_shop_id`),
  ADD KEY `sssb_suburb_id` (`sssb_suburb_id`);

--
-- Indexes for table `suburbs`
--
ALTER TABLE `suburbs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`,`cities_id`),
  ADD KEY `index_suburbs_on_cities_id` (`cities_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_addresses`
--
ALTER TABLE `users_addresses`
  ADD PRIMARY KEY (`add_id`),
  ADD KEY `add_user_id` (`add_user_id`),
  ADD KEY `add_suburg_id` (`add_suburb_id`);

--
-- Indexes for table `users_favorite_restaurants`
--
ALTER TABLE `users_favorite_restaurants`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_id_2` (`user_id`,`restaurant_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `restaurant_id` (`restaurant_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cities`
--
ALTER TABLE `cities`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `credit_cards`
--
ALTER TABLE `credit_cards`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cuisines`
--
ALTER TABLE `cuisines`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `donations`
--
ALTER TABLE `donations`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `foods`
--
ALTER TABLE `foods`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `food_parts`
--
ALTER TABLE `food_parts`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `food_part_ingredients`
--
ALTER TABLE `food_part_ingredients`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `ingredients`
--
ALTER TABLE `ingredients`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `menus`
--
ALTER TABLE `menus`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `order_items`
--
ALTER TABLE `order_items`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_item_ingredients`
--
ALTER TABLE `order_item_ingredients`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `perfectures`
--
ALTER TABLE `perfectures`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `restaurants`
--
ALTER TABLE `restaurants`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `restaurants_cuisines`
--
ALTER TABLE `restaurants_cuisines`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `shops`
--
ALTER TABLE `shops`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `shops_serving_suburbs`
--
ALTER TABLE `shops_serving_suburbs`
  MODIFY `sssb_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `suburbs`
--
ALTER TABLE `suburbs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users_addresses`
--
ALTER TABLE `users_addresses`
  MODIFY `add_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users_favorite_restaurants`
--
ALTER TABLE `users_favorite_restaurants`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cities`
--
ALTER TABLE `cities`
  ADD CONSTRAINT `fk_rails_467d4ae28f` FOREIGN KEY (`perfectures_id`) REFERENCES `perfectures` (`id`);

--
-- Constraints for table `credit_cards`
--
ALTER TABLE `credit_cards`
  ADD CONSTRAINT `credit_cards_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `foods`
--
ALTER TABLE `foods`
  ADD CONSTRAINT `fk_rails_68f95b473c` FOREIGN KEY (`restaurants_id`) REFERENCES `restaurants` (`id`),
  ADD CONSTRAINT `fk_rails_cf2048325b` FOREIGN KEY (`cuisines_id`) REFERENCES `cuisines` (`id`),
  ADD CONSTRAINT `fk_rails_ee56ac7f20` FOREIGN KEY (`menus_id`) REFERENCES `menus` (`id`);

--
-- Constraints for table `food_parts`
--
ALTER TABLE `food_parts`
  ADD CONSTRAINT `fk_rails_364e34fc6f` FOREIGN KEY (`foods_id`) REFERENCES `foods` (`id`);

--
-- Constraints for table `food_part_ingredients`
--
ALTER TABLE `food_part_ingredients`
  ADD CONSTRAINT `food_part_ingredients_ibfk_1` FOREIGN KEY (`food_part_id`) REFERENCES `food_parts` (`id`),
  ADD CONSTRAINT `food_part_ingredients_ibfk_2` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`);

--
-- Constraints for table `ingredients`
--
ALTER TABLE `ingredients`
  ADD CONSTRAINT `ingredients_ibfk_1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`);

--
-- Constraints for table `menus`
--
ALTER TABLE `menus`
  ADD CONSTRAINT `fk_rails_151ee1f387` FOREIGN KEY (`restaurants_id`) REFERENCES `restaurants` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_rails_d3f93ab604` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `order_items`
--
ALTER TABLE `order_items`
  ADD CONSTRAINT `fk_rails_0eb6a555b3` FOREIGN KEY (`food_id`) REFERENCES `foods` (`id`);

--
-- Constraints for table `order_item_ingredients`
--
ALTER TABLE `order_item_ingredients`
  ADD CONSTRAINT `fk_rails_22d8011845` FOREIGN KEY (`order_items_id`) REFERENCES `order_items` (`id`),
  ADD CONSTRAINT `fk_rails_a9318b8220` FOREIGN KEY (`ingredients_id`) REFERENCES `ingredients` (`id`);

--
-- Constraints for table `restaurants_cuisines`
--
ALTER TABLE `restaurants_cuisines`
  ADD CONSTRAINT `fk_rails_8066da1e97` FOREIGN KEY (`restaurants_id`) REFERENCES `restaurants` (`id`),
  ADD CONSTRAINT `fk_rails_d4c5d78350` FOREIGN KEY (`cuisines_id`) REFERENCES `cuisines` (`id`);

--
-- Constraints for table `shops`
--
ALTER TABLE `shops`
  ADD CONSTRAINT `fk_rails_ac5ebe5fef` FOREIGN KEY (`suburbs_id`) REFERENCES `suburbs` (`id`),
  ADD CONSTRAINT `fk_rails_dbd5ad31d1` FOREIGN KEY (`restaurants_id`) REFERENCES `restaurants` (`id`);

--
-- Constraints for table `shops_serving_suburbs`
--
ALTER TABLE `shops_serving_suburbs`
  ADD CONSTRAINT `shops_serving_suburbs_ibfk_1` FOREIGN KEY (`sssb_shop_id`) REFERENCES `shops` (`id`),
  ADD CONSTRAINT `shops_serving_suburbs_ibfk_2` FOREIGN KEY (`sssb_suburb_id`) REFERENCES `suburbs` (`id`);

--
-- Constraints for table `suburbs`
--
ALTER TABLE `suburbs`
  ADD CONSTRAINT `fk_rails_fcbc42e279` FOREIGN KEY (`cities_id`) REFERENCES `cities` (`id`);

--
-- Constraints for table `users_addresses`
--
ALTER TABLE `users_addresses`
  ADD CONSTRAINT `users_addresses_ibfk_1` FOREIGN KEY (`add_suburb_id`) REFERENCES `suburbs` (`id`),
  ADD CONSTRAINT `users_addresses_ibfk_2` FOREIGN KEY (`add_user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `users_favorite_restaurants`
--
ALTER TABLE `users_favorite_restaurants`
  ADD CONSTRAINT `users_favorite_restaurants_ibfk_1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`),
  ADD CONSTRAINT `users_favorite_restaurants_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;