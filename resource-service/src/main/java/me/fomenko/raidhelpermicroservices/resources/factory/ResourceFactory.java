package me.fomenko.raidhelpermicroservices.resources.factory;

import me.fomenko.raidhelpermicroservices.resources.exception.ResourceRuntimeException;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResourceFactory {
    private final Map<ResourceType, IResourceCreator> factoryMap = new HashMap<>();

    public ResourceFactory(IResourceCreator commonCreator,
                           IResourceCreator dyePotionCreator) {
        factoryMap.put(ResourceType.ARTIFACT, commonCreator);
        factoryMap.put(ResourceType.ATTRIBUTE, commonCreator);
        factoryMap.put(ResourceType.DYE_POTION, dyePotionCreator);
        factoryMap.put(ResourceType.MONEY, commonCreator);
    }

    public IResourceCreator getCreator(ResourceType resourceType) {
        if(!factoryMap.containsKey(resourceType)) {
            throw new ResourceRuntimeException("Creator does not exists.");
        }
        return factoryMap.get(resourceType);
    }
}
