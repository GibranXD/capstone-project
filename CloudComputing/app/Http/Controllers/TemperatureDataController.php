<?php

namespace App\Http\Controllers;

use App\Models\TemperatureData;
use Illuminate\Http\Request;

class TemperatureDataController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $temperatureData = TemperatureData::all();
       return response()->json([
            'code'=>200,
            'status'=>'success',
            'temperatureData'=>$temperatureData
        ]);
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(TemperatureData $temperatureData)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(TemperatureData $temperatureData)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, TemperatureData $temperatureData)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(TemperatureData $temperatureData)
    {
        //
    }
}
