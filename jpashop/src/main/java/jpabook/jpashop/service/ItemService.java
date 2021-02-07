package jpabook.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	@Transactional
	public void saveItem(Item item) {
		itemRepository.save(item);
	}
	
	//merge 쓰는 것보다 변경감지기능 사용하는 게 더 나은 코드
	@Transactional
	public void updateItem(Long itemId, Item itemParam) {
		Item findItem = itemRepository.findOne(itemId);
		findItem.setPrice(itemParam.getPrice());
		findItem.setName(itemParam.getName());
		findItem.setStockQuantity(itemParam.getStockQuantity());
	}
	
	
	public List<Item> findItems(){
		return itemRepository.findAll();
	}
	
	public Item findOne(Long itemId) {
		return itemRepository.findOne(itemId);
	}
}
