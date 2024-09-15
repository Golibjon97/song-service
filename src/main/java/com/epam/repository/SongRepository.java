package com.epam.repository;

import com.epam.entity.Metadata;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Metadata, Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM metadata WHERE s3location_id = :s3location_id", nativeQuery = true)
    void deleteByS3Location(@Param("s3location_id") Integer s3location_id);

    @Query(
            value = "SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM metadata t WHERE t.s3location_id = :id",
            nativeQuery = true
    )
    boolean existsByS3LocationId(@Param("id") Integer id);

}
