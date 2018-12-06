package Types;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.Meta_data;

public class GisLayerp implements GIS_layer {
	private HashSet<GIS_element> Geom = new HashSet<GIS_element>();
	private MetaDataLayerp metadata=new MetaDataLayerp();
	
	public GisLayerp(HashSet<GIS_element> s1) {
		this.Geom=s1;
	}
	
	@Override
	public boolean add(GIS_element arg0) {
		// TODO Auto-generated method stub
		return Geom.add( arg0);

	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> arg0) {
		// TODO Auto-generated method stub
		//return Geom.addAll((Collection<? extends Geom_Element>) arg0);
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Geom.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return Geom.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return Geom.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return Geom.isEmpty();
	}

	@Override
	public Iterator<GIS_element> iterator() {
		// TODO Auto-generated method stub
		
		return Geom.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return Geom.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return Geom.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return Geom.retainAll(arg0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Geom.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return Geom.toArray();
		
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return Geom.toArray(arg0);
	}

	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		
		return metadata;
	}


}
