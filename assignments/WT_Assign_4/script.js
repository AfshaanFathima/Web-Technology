// Configuration
const terrains = ["water", "land", "forest"];
const terrainSpeeds = {
  dog: { water: 1, land: 3, forest: 1 },
  turtle: { water: 3, land: 1, forest: 1 },
  monkey: { water: 1, land: 1, forest: 3 },
};
const foodBoosts = {
  "🍌": { monkey: 50 },  // Significantly increased boost for monkey
  "🍖": { dog: 50 },     // Significantly increased boost for dog
  "🥬": { turtle: 50 },  // Significantly increased boost for turtle
};
const animals = {
  dog: document.getElementById("dog"),
  turtle: document.getElementById("turtle"),
  monkey: document.getElementById("monkey"),
};
const foods = [...document.querySelectorAll(".food")];

// Initialize game
function setupGame() {
  // Randomize terrains
  const terrainElements = document.querySelectorAll(".terrain");
  terrainElements.forEach((terrain, index) => {
    const randomType = terrains[Math.floor(Math.random() * terrains.length)];
    terrain.dataset.type = randomType;
    terrain.style.backgroundColor = randomType === "water" ? "#87CEEB" : randomType === "land" ? "#8B4513" : "#228B22";
  });

  // Randomize animal positions
  const animalKeys = Object.keys(animals);
  animalKeys.sort(() => Math.random() - 0.5);
  animalKeys.forEach((key, index) => {
    animals[key].style.top = `${20 + index * 100}px`;
    animals[key].style.left = "10px";
  });

  // Randomize food placement
  const containerWidth = document.getElementById("game-container").offsetWidth;
  foods.forEach((food) => {
    const randomLeft = Math.random() * (containerWidth - 40);
    const randomTop = 20 + Math.floor(Math.random() * 3) * 100;
    food.style.left = `${randomLeft}px`;
    food.style.top = `${randomTop}px`;
  });
}

// Start race
function startRace() {
  const interval = setInterval(() => {
    Object.keys(animals).forEach((animalKey) => {
      const animal = animals[animalKey];
      const currentLeft = parseInt(animal.style.left || "10");
      const terrainIndex = Math.floor(currentLeft / 100);
      const terrainType = document.querySelector(`#terrain${terrainIndex + 1}`)?.dataset.type || "land";

      // Get base speed
      let speed = terrainSpeeds[animalKey][terrainType];

      // Variable to hold total boost from foods
      let totalBoost = 0;

      // Check for food boost and compatibility
      foods.forEach((food) => {
        const foodRect = food.getBoundingClientRect();
        const animalRect = animal.getBoundingClientRect();
        if (
          animalRect.x < foodRect.x + foodRect.width &&
          animalRect.x + animalRect.width > foodRect.x &&
          animalRect.y < foodRect.y + foodRect.height &&
          animalRect.y + animalRect.height > foodRect.y
        ) {
          // Check if food is compatible with the animal
          const boost = foodBoosts[food.textContent]?.[animalKey] || 0;
          if (boost > 0) {
            // Add boost to total boost
            totalBoost += boost;
            food.style.display = "none"; // Remove food
            
            // Add glow effect to animal when food is consumed
            animal.style.boxShadow = "0 0 25px 5px rgba(255, 223, 0, 0.8)";
            
            // Reset glow effect after a short time (1 second)
            setTimeout(() => {
              animal.style.boxShadow = "";  // Remove glow after 1 second
            }, 1000);
          }
        }
      });

      // Apply total boost to speed
      speed += totalBoost;

      // Move animal with boosted speed
      animal.style.left = `${currentLeft + speed}px`;

      // Check if animal wins
      if (currentLeft + speed >= 560) {
        clearInterval(interval);
        alert(`${animalKey.toUpperCase()} wins the race!`);
      }
    });
  }, 50);  // Decrease interval to make the race faster
}

// Initialize and start the game
document.addEventListener("DOMContentLoaded", () => {
  setupGame();
  document.getElementById("start-button").addEventListener("click", startRace);
});
