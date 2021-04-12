package by.anton.shapestask.service;

import by.anton.shapestask.entity.Pyramid;

public class FindPyramidService {

    public boolean baseLiesOnXY(Pyramid pyramid) {
        boolean flag = false;
        if (pyramid.getBasePoint1().getZ() == 0 & pyramid.getBasePoint2().getZ() == 0 &
                pyramid.getBasePoint3().getZ() == 0 & pyramid.getBasePoint4().getZ() == 0) {
            flag = true;
        }
        return flag;
    }
    public boolean baseLiesOnXZ(Pyramid pyramid) {
        boolean flag = false;
        if (pyramid.getBasePoint1().getY() == 0 & pyramid.getBasePoint2().getY() == 0 &
                pyramid.getBasePoint3().getY() == 0 & pyramid.getBasePoint4().getY() == 0) {
            flag = true;
        }
        return flag;
    }
    public boolean baseLiesOnYZ(Pyramid pyramid) {
        boolean flag = false;
        if (pyramid.getBasePoint1().getX() == 0 & pyramid.getBasePoint2().getX() == 0 &
                pyramid.getBasePoint3().getX() == 0 & pyramid.getBasePoint4().getX() == 0) {
            flag = true;
        }
        return flag;
    }

    public boolean coordinatePlaneXYIntersection(Pyramid pyramid) {
        boolean flag = false;
        if(pyramid.getBasePoint1().getZ()<0 && pyramid.getTopPoint().getZ()>0){
            flag=true;
        }
        if(pyramid.getBasePoint1().getZ()>0 && pyramid.getTopPoint().getZ()<0){
            flag=true;
        }
        return flag;
    }
    public boolean coordinatePlaneXZIntersection(Pyramid pyramid) {
        boolean flag = false;
        if(pyramid.getBasePoint1().getY()<0 && pyramid.getTopPoint().getY()>0){
            flag=true;
        }
        if(pyramid.getBasePoint1().getY()>0 && pyramid.getTopPoint().getY()<0){
            flag=true;
        }
        return flag;
    }
    public boolean coordinatePlaneYZIntersection(Pyramid pyramid) {
        boolean flag = false;
        if(pyramid.getBasePoint1().getX()<0 && pyramid.getTopPoint().getX()>0){
            flag=true;
        }
        if(pyramid.getBasePoint1().getX()>0 && pyramid.getTopPoint().getX()<0){
            flag=true;
        }
        return flag;
    }
}
