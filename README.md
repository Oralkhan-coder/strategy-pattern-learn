Hero Battle Game (Strategy + Observer)

How to run (no build tool required):

1) Compile
   - From the project root:

   PowerShell:
   ```powershell
   $sources = Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName }
   javac -d out $sources
   ```

   Bash (optional):
   ```bash
   javac -d out $(find src/main/java -name "*.java")
   ```

2) Run
   - From the project root:

   ```bash
   java -cp out com.example.game.Game
   ```

Project structure

- `AttackStrategy` interface with `MeleeAttack`, `RangedAttack`, `MagicAttack`
- `Hero` base class with dynamic `AttackStrategy` and observer support
- Observer system: `HeroObserver`, `HeroEvent`, `EventType`
- Concrete heroes: `Warrior`, `Mage`, `Archer`
- Observers: `ConsoleLoggerObserver`, `AnnouncerObserver`
- `Game` main demonstrating strategy switching and event notifications


