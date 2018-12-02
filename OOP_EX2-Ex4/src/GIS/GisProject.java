package GIS;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
/**
 * the class implements GIS_project by creating a hash set of layers.
 * having all the operation of the hash set
 * @author ariel and moshe 
 *
 */
public class GisProject implements GIS_project {
	private HashSet<GIS_layer> Glayer = new HashSet<GIS_layer>();
	private MetaDataProject metadata=new MetaDataProject();
	@Override
	public boolean add(GIS_layer arg0) {
		// TODO Auto-generated method stub
		return Glayer.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_layer> arg0) {
		// TODO Auto-generated method stub
		return Glayer.addAll(arg0);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Glayer.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return Glayer.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return Glayer.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return Glayer.isEmpty();
	}

	@Override
	public Iterator<GIS_layer> iterator() {
		// TODO Auto-generated method stub
		return Glayer.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return Glayer.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return Glayer.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return Glayer.retainAll(arg0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Glayer.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return Glayer.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return Glayer.toArray(arg0);
	}

	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return metadata ;
	}

}
