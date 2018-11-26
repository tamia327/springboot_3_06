package com.example.springboot_3_06;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {}
