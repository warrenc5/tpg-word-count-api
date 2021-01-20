package com.app.controller.counter;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.counter.FileCounterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getTopResultsApi")
@Api(tags= {"FileCounter"}, description="Rest Service to obtain word counts from file")
public class CounterExportController {
	
	@Autowired
    private FileCounterService counterService;
	
	@ApiOperation(value = "Returns back to the user for top recurring words based on passed count")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list containing the top recurring words"),
            @ApiResponse(code = 500, message = "The server encountered error. Please contact administrator!")
    })
	@GetMapping
	public Object getTopFileResults(@ApiParam(name="count", value="Limiter for results", required=true) @RequestParam("count") Integer count) throws IOException {
		return counterService.getTopFileResults(count);
	}
}
