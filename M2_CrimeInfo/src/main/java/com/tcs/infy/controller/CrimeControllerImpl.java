package com.tcs.infy.controller;

import com.tcs.infy.entity.Crime;
import com.tcs.infy.service.CrimeService;
import common.tcs.infy.mapper.response.vo.CrimeVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/crime")
public class CrimeControllerImpl extends VoMapper implements CrimeController{

    @Autowired
    CrimeService accusedService;


    @Override
    @GetMapping(value = "/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CrimeVo> findByAccusedName(@ApiParam(value = "Accused name as input", required = true, defaultValue = "ILAN") @PathVariable("name") String name)
    {
        return accusedService.findByAccusedName(name).stream().map(p->entityToVo.apply(p)).collect(Collectors.toList());
    }

    @Override
    @GetMapping(value = "/count/{countNo}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CrimeVo> crimeCountGreaterThan(@ApiParam(value = "Crime Count as input", required = true, defaultValue = "2") @PathVariable("countNo") int count)
    {
        return accusedService.crimeCountGreaterThan(count).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
    }



    @Override
    @GetMapping(value = "/name/count/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CrimeVo> findByAccusedNameAndCrimeCount(@ApiParam(value = "Accused name as input", required = true, defaultValue = "ILAN")  @RequestParam("accusedName") String name, @ApiParam(value = "Crime Count as input", required = true, defaultValue = "1") @RequestParam(value = "arrestedCount") int count)
    {
        return accusedService.findByAccusedNameAndCrimeCount(name,count).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
    }


    @Override
    @PostMapping(value = "/save/all/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CrimeVo> saveAllCrime(@RequestBody List<Crime> accused)
    {
        return accusedService.saveAll(accused).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
    }


    @Override
    @PostMapping(value = "/save/only/one/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public CrimeVo saveCrime(@RequestBody Crime accused)
    {
        return entityToVo.apply(accusedService.save(accused));
    }

}
