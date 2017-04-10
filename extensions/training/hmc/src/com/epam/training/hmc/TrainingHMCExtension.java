import de.hybris.platform.hmc.AbstractEditorMenuChip;
import de.hybris.platform.hmc.AbstractExplorerMenuTreeNodeChip;
import de.hybris.platform.hmc.EditorTabChip;
import de.hybris.platform.hmc.extension.HMCExtension;
import de.hybris.platform.hmc.extension.MenuEntrySlotEntry;
import de.hybris.platform.hmc.generic.ClipChip;
import de.hybris.platform.hmc.generic.ToolbarActionChip;
import de.hybris.platform.hmc.webchips.Chip;
import de.hybris.platform.hmc.webchips.DisplayState;

import java.util.*;

public class TrainingHMCExtension extends HMCExtension {
    public static final String RESOURCE_PATH = "com.epam.training.hmc.locales";

    @Override
    public List<EditorTabChip> getEditorTabChips(DisplayState displayState, AbstractEditorMenuChip abstractEditorMenuChip) {
        return Collections.emptyList();
    }

    @Override
    public List<AbstractExplorerMenuTreeNodeChip> getTreeNodeChips(DisplayState displayState, Chip chip) {
        return Collections.emptyList();
    }

    @Override
    public List<MenuEntrySlotEntry> getMenuEntrySlotEntries(DisplayState displayState, Chip chip) {
        return Collections.emptyList();
    }

    @Override
    public List<ClipChip> getSectionChips(DisplayState displayState, ClipChip clipChip) {
        return Collections.emptyList();
    }

    @Override
    public List<ToolbarActionChip> getToolbarActionChips(DisplayState displayState, Chip chip) {
        return Collections.emptyList();
    }

    @Override
    public ResourceBundle getLocalizeResourceBundle(Locale locale) throws MissingResourceException {
        return null;
    }

    @Override
    public String getResourcePath() {
        return RESOURCE_PATH;
    }
}
