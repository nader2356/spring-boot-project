package com.school.pfe.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.pfe.Model.ClassRoom;


@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom,Long>{

		

}

