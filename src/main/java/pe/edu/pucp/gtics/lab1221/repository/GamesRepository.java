package pe.edu.pucp.gtics.lab1221.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.pucp.gtics.lab1221.entity.Games;

public interface GamesRepository extends JpaRepository<Games,Integer> {
}
