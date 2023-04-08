
# Java Built 2D Ray Marcher
The ray marching algorithm uses a signed distance function (SDF) to determine the distance from the current point along the ray to the nearest object in the scene. The SDF takes the position of a point in space as input and returns a value that is negative inside an object, positive outside it, and zero at the object's surface.

The ray marching algorithm iteratively steps along the ray in small increments, computing the SDF at each point, until it finds a point where the SDF is zero, indicating that the ray has intersected with an object.

## Demo
<p align="center">
  <img width="640" height="642" src="media/rayMarchGif.gif">
</p>



## Authors

- [@jetsonblack](https://www.github.com/jetsonblack)
- [@0lib3](https://github.com/0lib3)


## Features

- Real Time Calculations and Visualizations based on Mouse Movement
- Angle can be changed by either Mouse Clicks, or the Arrow Keys
- Random Generation of Shapes in a given JPanel
- Visualization of Ray Marching as a concept in a 2D Space
